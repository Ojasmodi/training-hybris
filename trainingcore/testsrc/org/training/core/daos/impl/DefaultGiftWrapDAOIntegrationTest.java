/**
 *
 */
package org.training.core.daos.impl;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.training.core.dao.GiftWrapDAO;
import org.training.core.enums.GiftWrapType;
import org.training.core.model.GiftWrapModel;


/**
 * @author ojasmodi
 *
 */

@IntegrationTest
public class DefaultGiftWrapDAOIntegrationTest extends ServicelayerTransactionalTest
{

	/** As this is an integration test, the class (object) being tested gets injected here. */
	@Resource
	private GiftWrapDAO giftWrapDAO;
	/** Platform's ModelService used for creation of test data. */
	@Resource
	private ModelService modelService;
	private static final String GIFT_WRAP_CODE = "6";
	private static final Double GIFT_WRAP_COST = 56.0;
	private static final String GIFT_WRAP_DESCRIPTION = "All female rock band formed in Munich in the late 1990s";
	private static final GiftWrapType GIFT_WRAP_TYPE = GiftWrapType.PREMIUM;

	// @Before
	public void setUp() throws Exception
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
	}

	@Test
	public void giftWrapDAOTest()
	{

		List<GiftWrapModel> giftWrapByType;
		List<GiftWrapModel> allGiftWraps = giftWrapDAO.getAllGiftWraps();
		final int size = allGiftWraps.size();

		final GiftWrapModel giftWrapModel = modelService.create(GiftWrapModel.class);
		giftWrapModel.setCode(GIFT_WRAP_CODE);
		giftWrapModel.setGiftWrapType(GIFT_WRAP_TYPE);
		giftWrapModel.setDescription(GIFT_WRAP_DESCRIPTION);
		giftWrapModel.setCost(GIFT_WRAP_COST);
		modelService.save(giftWrapModel);

		allGiftWraps = giftWrapDAO.getAllGiftWraps();
		Assert.assertEquals(size + 1, allGiftWraps.size());
		Assert.assertTrue("giftwrap found", allGiftWraps.contains(giftWrapModel));

		giftWrapByType = giftWrapDAO.getGiftWrapsByGiftWrapType(GIFT_WRAP_TYPE);
		Assert.assertEquals("Did not find the GIFTWRAP we just saved", 1, giftWrapByType.size());

	}


	@Test(expected = IllegalArgumentException.class)
	public void testfindBands_NullParam()
	{
		giftWrapDAO.getGiftWrapsByGiftWrapType(null); //method's return value not captured
	}


}
