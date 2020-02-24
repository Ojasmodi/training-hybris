/**
 *
 */
package org.training.facades.populators;

import de.hybris.platform.commercefacades.order.converters.populator.CartPopulator;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.core.model.order.CartModel;

/**
 * @author ojasmodi
 *
 */
public class CustomCartPopulator extends CartPopulator<CartData> {

	@Override
	public void populate(final CartModel source, final CartData target)
	{
		super.populate(source, target);
		target.setCartDataPk(source.getPk());

	}

}
