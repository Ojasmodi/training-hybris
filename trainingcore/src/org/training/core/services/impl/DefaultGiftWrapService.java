/**
 *
 */
package org.training.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.training.core.dao.GiftWrapDAO;
import org.training.core.enums.GiftWrapType;
import org.training.core.model.GiftWrapModel;
import org.training.core.services.GiftWrapService;


/**
 * @author ojasmodi
 *
 */

//@Component
public class DefaultGiftWrapService implements GiftWrapService
{

	@Autowired
	private GiftWrapDAO giftWrapDAO;

	@Override
	public List<GiftWrapModel> getAllGiftWraps()
	{
		return giftWrapDAO.getAllGiftWraps();
	}


	@Override
	public List<GiftWrapModel> getGiftWrapsByGiftWrapType(final GiftWrapType wrapType)
	{
		return giftWrapDAO.getGiftWrapsByGiftWrapType(wrapType);
	}


	/**
	 * @param giftWrapDAO2
	 */
	public void setGiftWrapDAO(final GiftWrapDAO giftWrapDAO)
	{
		this.giftWrapDAO = giftWrapDAO;

	}

}
