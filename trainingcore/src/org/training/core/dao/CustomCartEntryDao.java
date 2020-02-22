/**
 *
 */
package org.training.core.dao;

import de.hybris.platform.commerceservices.order.dao.CartEntryDao;
import de.hybris.platform.core.model.order.CartEntryModel;


/**
 * @author ojasmodi
 *
 */
public interface CustomCartEntryDao extends CartEntryDao
{

	public CartEntryModel findCartEntryByCartEntryProductCode(final String cartEntryProductCode);

}
