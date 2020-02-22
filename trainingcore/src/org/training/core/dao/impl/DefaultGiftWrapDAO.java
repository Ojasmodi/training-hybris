/**
 *
 */
package org.training.core.dao.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.List;

import org.training.core.dao.GiftWrapDAO;
import org.training.core.enums.GiftWrapType;
import org.training.core.model.GiftWrapModel;


/**
 * @author ojasmodi
 *
 */

public class DefaultGiftWrapDAO implements GiftWrapDAO
{

	private FlexibleSearchService flexibleSearchService;


	/**
	 * @param flexibleSearchService
	 *           the flexibleSearchService to set
	 */
	public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
	{
		this.flexibleSearchService = flexibleSearchService;
	}


	@Override
	public List<GiftWrapModel> getAllGiftWraps()
	{
		final String queryString = "SELECT {pk} FROM {" + GiftWrapModel._TYPECODE + "}"; // correct way of writing query
		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		return flexibleSearchService.<GiftWrapModel> search(query).getResult();
	}


	@Override
	public GiftWrapModel getGiftWrapByGiftWrapType(final GiftWrapType wrapType)
	{

		final String queryString = "SELECT {pk} FROM {" + GiftWrapModel._TYPECODE + "} WHERE {" + GiftWrapModel.GIFTWRAPTYPE
				+ "}=?wrapType";
		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		query.addQueryParameter("wrapType", wrapType);
		return flexibleSearchService.<GiftWrapModel> search(query).getResult().get(0);

	}


}
