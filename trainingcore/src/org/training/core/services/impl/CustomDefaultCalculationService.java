/**
 *
 */
package org.training.core.services.impl;

import de.hybris.platform.core.model.c2l.CurrencyModel;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.order.impl.DefaultCalculationService;
import de.hybris.platform.order.strategies.calculation.OrderRequiresCalculationStrategy;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.util.DiscountValue;

import java.util.Iterator;
import java.util.List;


/**
 * @author ojasmodi
 *
 */
public class CustomDefaultCalculationService extends DefaultCalculationService
{

	private OrderRequiresCalculationStrategy orderRequiresCalculationStrategy;

	private CommonI18NService commonI18NService;


	@Override
	public void calculateTotals(final AbstractOrderEntryModel entry, final boolean recalculate)
	{
		if (recalculate || orderRequiresCalculationStrategy.requiresCalculation(entry))
		{
			final AbstractOrderModel order = entry.getOrder();
			final CurrencyModel curr = order.getCurrency();
			final int digits = curr.getDigits().intValue();

			double giftWrapPrice = 0.0;
			if (entry.getGiftWrap() != null)
			{
				giftWrapPrice += (entry.getGiftWrap().getCost().doubleValue() * entry.getQuantity().doubleValue());
			}

			final double totalPriceWithoutDiscount = commonI18NService
					.roundCurrency(entry.getBasePrice().doubleValue() * entry.getQuantity().longValue(), digits) + giftWrapPrice;
			;
			final double quantity = entry.getQuantity().doubleValue();
			/*
			 * apply discounts (will be rounded each) convert absolute discount values in case their currency doesn't match the
			 * order currency
			 */
			//YTODO : use CalculatinService methods to apply discounts
			final List appliedDiscounts = DiscountValue.apply(quantity, totalPriceWithoutDiscount, digits,
					convertDiscountValues(order, entry.getDiscountValues()), curr.getIsocode());
			entry.setDiscountValues(appliedDiscounts);
			double totalPrice = totalPriceWithoutDiscount;
			for (final Iterator it = appliedDiscounts.iterator(); it.hasNext();)
			{
				totalPrice -= ((DiscountValue) it.next()).getAppliedValue();
			}
			// set total price
			entry.setTotalPrice(Double.valueOf(totalPrice));
			// apply tax values too
			//YTODO : use CalculatinService methods to apply taxes
			calculateTotalTaxValues(entry);
			setCalculatedStatus(entry);
			getModelService().save(entry);
		}
	}

	/**
	 * @param commonI18NService
	 *           the commonI18NService to set
	 */
	@Override
	public void setCommonI18NService(final CommonI18NService commonI18NService)
	{
		super.setCommonI18NService(commonI18NService);
		this.commonI18NService = commonI18NService;
	}

	/**
	 * @param orderRequiresCalculationStrategy
	 *           the orderRequiresCalculationStrategy to set
	 */
	@Override
	public void setOrderRequiresCalculationStrategy(final OrderRequiresCalculationStrategy orderRequiresCalculationStrategy)
	{
		super.setOrderRequiresCalculationStrategy(orderRequiresCalculationStrategy);
		this.orderRequiresCalculationStrategy = orderRequiresCalculationStrategy;
	}

}
