/**
 *
 */
package org.training.core.services.impl;

import de.hybris.platform.core.model.order.CartEntryModel;
import de.hybris.platform.enumeration.EnumerationService;
import de.hybris.platform.order.impl.DefaultCartEntryService;

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
	/**
	 * @param customCartEntryDao
	 *           the customCartEntryDao to set
	 */
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

	private CustomCartEntryDao customCartEntryDao;

	private GiftWrapService giftWrapService;

	private EnumerationService enumerationService;

	//ModelService modelService;

	public void setGiftWrapForCartOrderEntry(final String cartEntryProductCode, final String giftWrapCode,
			final String cartEntryCode)
	{
		final CartEntryModel cartEntryModel = customCartEntryDao.findCartEntryByCartEntryProductCode(cartEntryProductCode);
		final GiftWrapType giftWrapType = enumerationService.getEnumerationValue(GiftWrapType.class, giftWrapCode);
		final GiftWrapModel giftWrapModel = giftWrapService.getGiftWrapByGiftWrapType(giftWrapType);
		cartEntryModel.setGiftWrap(giftWrapModel);
		cartEntryModel.setTotalPrice((cartEntryModel.getBasePrice() + giftWrapModel.getCost()) * cartEntryModel.getQuantity());
		//CartModel cartModel=findByCartCode(cartEntryCode);
		modelService.save(cartEntryModel);
	}

}
