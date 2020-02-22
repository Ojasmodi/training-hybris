/**
 *
 */
package org.training.core.dao;

import java.util.List;

import org.training.core.enums.GiftWrapType;
import org.training.core.model.GiftWrapModel;


/**
 * @author ojasmodi
 *
 */
public interface GiftWrapDAO
{

	public List<GiftWrapModel> getAllGiftWraps();

	public GiftWrapModel getGiftWrapByGiftWrapType(GiftWrapType wrapType);
}
