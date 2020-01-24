/**
 *
 */
package org.training.core.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.training.core.dao.GiftWrapDAO;
import org.training.core.enums.GiftWrapType;
import org.training.core.model.GiftWrapModel;
import org.training.core.services.impl.DefaultGiftWrapService;


/**
 * @author ojasmodi
 *
 */
@UnitTest
public class DefaultGiftWrapServiceUnitTest
{

	private DefaultGiftWrapService giftWrapService;
	private GiftWrapDAO giftWrapDAO;
	private GiftWrapModel giftWrapModel;

	private static final String GIFT_WRAP_CODE = "6";

	private static final Integer GIFT_WRAP_COST = 56;

	private static final String GIFT_WRAP_DESCRIPTION = "All female rock giftWrap formed in Munich in the late 1990s";

	private static final GiftWrapType GIFT_WRAP_TYPE = GiftWrapType.PREMIUM;


	@Before
	public void setUp()
	{
		giftWrapService = new DefaultGiftWrapService();
		// So as not to implicitly also test the DAO, we will mock out the DAO using Mockito
		giftWrapDAO = mock(GiftWrapDAO.class);
		// and inject this mocked DAO into the GiftWrapService
		giftWrapService.setGiftWrapDAO(giftWrapDAO);
		// This instance of a GiftWrapModel will be used by the tests
		giftWrapModel = new GiftWrapModel();
		giftWrapModel.setCode(GIFT_WRAP_CODE);
		giftWrapModel.setType(GIFT_WRAP_TYPE);
		giftWrapModel.setDescription(GIFT_WRAP_DESCRIPTION);
		giftWrapModel.setCost(GIFT_WRAP_COST);
	}

	/**
	 * This test tests and demonstrates that the Service's getAllGiftWraps method calls the DAOs' getGiftWraps method and
	 * returns the data it receives from it.
	 */
	@Test
	public void testGetAllGiftWraps()
	{


		// We construct the data we would like the mocked out DAO to return when called
		final List<GiftWrapModel> giftWrapModels = Arrays.asList(giftWrapModel);
		//Use Mockito and compare results
		when(giftWrapDAO.getAllGiftWraps()).thenReturn(giftWrapModels);
		// Now we make the call to GiftWrapService's getGiftWraps() which we expect to call the DAOs' findGiftWraps() method
		final List<GiftWrapModel> result = giftWrapService.getAllGiftWraps();
		// We then verify that the results returned from the service match those returned by the mocked-out DAO
		assertEquals("We should find one", 1, result.size());
		assertEquals("And should equals what the mock returned", giftWrapModel, result.get(0));
	}

	@Test
	public void testGetGiftWrap()
	{

		// Tell Mockito we expect a call to the DAO's getGiftWrap(), and, if it occurs, Mockito should return GiftWrapModel instance
		when(giftWrapDAO.getGiftWrapsByGiftWrapType(GIFT_WRAP_TYPE)).thenReturn(Collections.singletonList(giftWrapModel));
		// We make the call to the Service's getGiftWrapForCode() which we expect to call the DAO's findGiftWrapsByCode()
		final GiftWrapModel result = giftWrapService.getGiftWrapsByGiftWrapType(GIFT_WRAP_TYPE).get(0);
		// We then verify that the result returned from the Service is the same as that returned from the DAO
		assertEquals("GiftWrap should equals() what the mock returned", giftWrapModel, result);
	}
}
