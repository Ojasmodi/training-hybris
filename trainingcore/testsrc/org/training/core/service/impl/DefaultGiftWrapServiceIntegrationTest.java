/**
 *
 */
package org.training.core.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.training.core.enums.GiftWrapType;
import org.training.core.model.GiftWrapModel;
import org.training.core.services.impl.DefaultGiftWrapService;



/**
 * @author ojasmodi
 *
 */
@IntegrationTest
public class DefaultGiftWrapServiceIntegrationTest extends ServicelayerTest
{

	@Resource
	private DefaultGiftWrapService defaultGiftWrapService;

	@Resource
	private ModelService modelService;

	private GiftWrapModel giftWrapModel;

	private static final String GIFT_WRAP_CODE = "7";

	private static final Double GIFT_WRAP_COST = 56.0;

	private static final String GIFT_WRAP_DESCRIPTION = "All female rock band formed in Munich in the late 1990s";

	private static final GiftWrapType GIFT_WRAP_TYPE = GiftWrapType.PREMIUM;


	//@Before
	public void setUp()
	{
		try
		{
			Thread.sleep(TimeUnit.SECONDS.toMillis(1));
			new JdbcTemplate(Registry.getCurrentTenant().getDataSource()).execute("CHECKPOINT");
			Thread.sleep(TimeUnit.SECONDS.toMillis(1));
		}
		catch (final InterruptedException exc)
		{
		}
		// This instance of a GiftWrapModel will be used by the tests

	}



	/**
	 * This test tests and demonstrates that the Service's getAllBand method calls the DAOs' getAllBand method and returns
	 * the data it receives from it.
	 */
	@Test
	public void testBandService()
	{
		giftWrapModel = modelService.create(GiftWrapModel.class);
		giftWrapModel.setCode(GIFT_WRAP_CODE);
		giftWrapModel.setGiftWrapType(GIFT_WRAP_TYPE);
		giftWrapModel.setDescription(GIFT_WRAP_DESCRIPTION);
		giftWrapModel.setCost(GIFT_WRAP_COST);
		modelService.save(giftWrapModel);

		List<GiftWrapModel> giftWrapModels = defaultGiftWrapService.getAllGiftWraps();
		final int size = giftWrapModels.size();

		giftWrapModels = defaultGiftWrapService.getAllGiftWraps();
		assertEquals("Unexpected giftWrap found", giftWrapModel, giftWrapModels.get(giftWrapModels.size() - 1));
		final GiftWrapModel persistedGiftWrapModel = defaultGiftWrapService.getGiftWrapsByGiftWrapType(GIFT_WRAP_TYPE).get(0);
		assertNotNull("No giftWrap found", persistedGiftWrapModel);
		assertEquals("Different giftWrap found", giftWrapModel, persistedGiftWrapModel);
	}
}
