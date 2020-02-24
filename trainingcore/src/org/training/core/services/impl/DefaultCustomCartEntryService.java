/**
 *
 */
package org.training.core.services.impl;

import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.CartEntryModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.enumeration.EnumerationService;
import de.hybris.platform.order.impl.DefaultCartEntryService;

import java.util.List;

import org.training.core.dao.CustomCartEntryDao;
import org.training.core.enums.GiftWrapType;
import org.training.core.model.GiftWrapModel;
import org.training.core.services.CustomCartEntryService;
import org.training.core.services.GiftWrapService;


/**
 * @author ojasmodi
 *
 */
public class DefaultCustomCartEntryService extends DefaultCartEntryService implements CustomCartEntryService

{
	private CustomCartEntryDao customCartEntryDao;

	private GiftWrapService giftWrapService;

	private EnumerationService enumerationService;

	@Override
	public void setGiftWrapForCartOrderEntry(final String cartOrderEntryPk, final String giftWrapCode, final String cartPk)
	{
		final CartEntryModel cartEntryModel = (CartEntryModel) modelService.get(PK.parse(cartOrderEntryPk));

		final GiftWrapType giftWrapType = enumerationService.getEnumerationValue(GiftWrapType.class, giftWrapCode);

		final GiftWrapModel giftWrapModel = giftWrapService.getGiftWrapByGiftWrapType(giftWrapType);
		cartEntryModel.setGiftWrap(giftWrapModel);

		final CartModel cartModel = (CartModel) modelService.get(PK.parse(cartPk));
		final List<AbstractOrderEntryModel> abstractOrderEntries = cartModel.getEntries();

		double cartTotalPrice = 0.0;
		for (final AbstractOrderEntryModel aem : abstractOrderEntries)
		{
			double entryPrice = 0.0;
			if (aem.getPk().toString().equals(cartOrderEntryPk))
			{
				entryPrice = (cartEntryModel.getBasePrice() + giftWrapModel.getCost()) * cartEntryModel.getQuantity();
				aem.setTotalPrice(entryPrice);
				modelService.save(cartEntryModel);
			}
			else
			{
				entryPrice = aem.getTotalPrice();
			}
			cartTotalPrice += entryPrice;
		}
		cartModel.setTotalPrice(cartTotalPrice);
		modelService.save(cartModel);
	}

	@Override
	public void removeGiftWrapFromOrderEntry(final String cartOrderEntryPk, final String cartPk)
	{
		final CartEntryModel cartEntryModel = (CartEntryModel) modelService.get(PK.parse(cartOrderEntryPk));

		final CartModel cartModel = (CartModel) modelService.get(PK.parse(cartPk));
		final List<AbstractOrderEntryModel> abstractOrderEntries = cartModel.getEntries();

		double cartTotalPrice = 0.0;
		for (final AbstractOrderEntryModel aem : abstractOrderEntries)
		{
			double entryPrice = 0.0;
			if (aem.getPk().toString().equals(cartOrderEntryPk))
			{
				entryPrice = cartEntryModel.getBasePrice() * cartEntryModel.getQuantity();
				aem.setTotalPrice(entryPrice);
				cartEntryModel.setGiftWrap(null);
				modelService.save(cartEntryModel);
			}
			else
			{
				entryPrice = aem.getTotalPrice();
			}
			cartTotalPrice += entryPrice;
		}
		cartModel.setTotalPrice(cartTotalPrice);
		modelService.save(cartModel);


	}


	public void setCustomCartEntryDao(final CustomCartEntryDao customCartEntryDao)
	{
		this.customCartEntryDao = customCartEntryDao;
	}

	/**
	 * @param giftWrapService
	 *           the giftWrapService to set
	 */
	public void setGiftWrapService(final GiftWrapService giftWrapService)
	{
		this.giftWrapService = giftWrapService;
	}

	/**
	 * @param enumerationService
	 *           the enumerationService to set
	 */
	public void setEnumerationService(final EnumerationService enumerationService)
	{
		this.enumerationService = enumerationService;
	}





}
