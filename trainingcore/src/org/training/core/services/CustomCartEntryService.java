/**
 *
 */
package org.training.core.services;

import de.hybris.platform.order.CartEntryService;


/**
 * @author ojasmodi
 *
 */
public interface CustomCartEntryService extends CartEntryService
{

	public void setGiftWrapForCartOrderEntry(final String cartEntryProductCode, final String giftWrapCode, String cartEntryCode);

	/**
	 * @param orderEntryPk
	 * @param cartPk
	 */
	public void removeGiftWrapFromOrderEntry(String orderEntryPk, String cartPk);


}
