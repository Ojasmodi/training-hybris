/**
 *
 */
package org.training.core.services.impl;

import java.util.List;

import org.training.core.dao.GiftWrapDAO;
import org.training.core.enums.GiftWrapType;
import org.training.core.model.GiftWrapModel;
import org.training.core.services.GiftWrapService;


/**
 * @author ojasmodi
 *
 */

public class DefaultGiftWrapService implements GiftWrapService
{
	private GiftWrapDAO giftWrapDAO;

	@Override
	public List<GiftWrapModel> getAllGiftWraps()
	{
		return giftWrapDAO.getAllGiftWraps();
	}


	@Override
	public GiftWrapModel getGiftWrapByGiftWrapType(final GiftWrapType wrapType)
	{
		return giftWrapDAO.getGiftWrapByGiftWrapType(wrapType);
	}


	/**
	 * @param giftWrapDAO2
	 */
	public void setGiftWrapDAO(final GiftWrapDAO giftWrapDAO)
	{
		this.giftWrapDAO = giftWrapDAO;

	}

}
