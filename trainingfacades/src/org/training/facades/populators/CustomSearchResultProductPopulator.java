/**
 *
 */
package org.training.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.converters.populator.SearchResultProductPopulator;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;


/**
 * @author ojasmodi
 *
 */
public class CustomSearchResultProductPopulator extends SearchResultProductPopulator
{
	@Override
	public void populate(final SearchResultValueData source, final ProductData target)
	{
		if (source != null)
		{
			// adding our attribute to product data
			target.setGiftWrapAvailable(source.getValues().containsKey("giftWrapAvailable"));
		}
		super.populate(source, target);
	}

}
