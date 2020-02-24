/**
 *
 */
package org.training.facades.populators;

import de.hybris.platform.commercefacades.order.converters.populator.OrderEntryPopulator;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;


/**
 * @author ojasmodi
 *
 */
public class CustomOrderEntryPopulator extends OrderEntryPopulator
{
	@Override
	protected void addCommon(final AbstractOrderEntryModel orderEntry, final OrderEntryData entry)
	{
		entry.setEntryNumber(orderEntry.getEntryNumber());
		entry.setQuantity(orderEntry.getQuantity());
		entry.setOrderEntryDataPk(orderEntry.getPk());
		entry.setGiftWrap(orderEntry.getGiftWrap());
		adjustUpdateable(entry, orderEntry);
	}

}
