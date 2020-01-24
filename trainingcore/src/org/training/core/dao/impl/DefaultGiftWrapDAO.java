/**
 *
 */
package org.training.core.dao.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.training.core.dao.GiftWrapDAO;
import org.training.core.enums.GiftWrapType;
import org.training.core.model.GiftWrapModel;


/**
 * @author ojasmodi
 *
 */

@Component(value = "giftWrapDAO")
public class DefaultGiftWrapDAO implements GiftWrapDAO
{

	@Autowired
	private FlexibleSearchService flexibleSearchService;


	@Override
	public List<GiftWrapModel> getAllGiftWraps()
	{
		final String queryString = "SELECT {pk} FROM {" + GiftWrapModel._TYPECODE + "}";
		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		return flexibleSearchService.<GiftWrapModel> search(query).getResult();
	}


	@Override
	public List<GiftWrapModel> getGiftWrapsByGiftWrapType(final GiftWrapType wrapType)
	{

		// here {GiftWrap} is the itemType defined in xml file
		final String queryString = //
				"SELECT {pk} FROM {GiftWrap} WHERE {TYPE} = ?type ";
		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		query.addQueryParameter("type", wrapType);
		return flexibleSearchService.<GiftWrapModel> search(query).getResult();

	}

	//	public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
	//	{
	//		this.flexibleSearchService = flexibleSearchService;
	//	}

}
