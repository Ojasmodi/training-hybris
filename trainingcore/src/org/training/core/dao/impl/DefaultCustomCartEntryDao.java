/**
 *
 */
package org.training.core.dao.impl;

import de.hybris.platform.commerceservices.order.dao.impl.DefaultCartEntryDao;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.CartEntryModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import org.training.core.dao.CustomCartEntryDao;


/**
 * @author ojasmodi
 *
 */
public class DefaultCustomCartEntryDao extends DefaultCartEntryDao implements CustomCartEntryDao
{

	/**
	 * @param cartEntryProductCode
	 * @return
	 */
	public CartEntryModel findCartEntryByCartEntryProductCode(final String cartEntryProductCode)
	{

		final String queryString = "SELECT {aoe.pk} FROM { " + AbstractOrderEntryModel._TYPECODE + " AS aoe JOIN "
				+ ProductModel._TYPECODE + " AS p ON {aoe.product} = {p.pk}} WHERE {p.code} = ?productCode";



		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		query.addQueryParameter("productCode", cartEntryProductCode);

		final SearchResult<AbstractOrderEntryModel> searchResult = flexibleSearchService.search(query);
		return (CartEntryModel) searchResult.getResult().get(0);
		//return (AbstractOrderEntryModel) flexibleSearchService.<AbstractOrderEntryModel> search(query).getResult();
	}

}
