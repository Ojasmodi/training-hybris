/**
 *
 */
package org.training.core.services;

import java.util.List;

import org.training.core.enums.GiftWrapType;
import org.training.core.model.GiftWrapModel;


/**
 * @author ojasmodi
 *
 */
public interface GiftWrapService
{

	public List<GiftWrapModel> getAllGiftWraps();

	public List<GiftWrapModel> getGiftWrapsByGiftWrapType(GiftWrapType wrapType);

}
