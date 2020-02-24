/**
 *
 */
package org.training.storefront.controllers.misc;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.core.model.GiftWrapModel;
import org.training.core.services.CustomCartEntryService;
import org.training.core.services.GiftWrapService;


/**
 * @author ojasmodi
 *
 */

@Controller
public class GiftWrapController extends AbstractPageController
{
	@Autowired
	private CustomCartEntryService cartEntryService;

	@Autowired
	private GiftWrapService giftWrapService;

	@RequestMapping(value = "/giftwrap/add", method = RequestMethod.POST, produces = "application/json")
	public String addGiftWrapToOrderEntry(@RequestParam("orderEntryPk") final String orderEntryPk,
			@RequestParam("giftWrapCode") final String giftWrapCode, final Model model)
	{
		cartEntryService.setGiftWrapForCartOrderEntry(orderEntryPk, giftWrapCode);

		return REDIRECT_PREFIX + "/cart";
	}

	@RequestMapping(value = "/giftwrap/remove", method = RequestMethod.POST, produces = "application/json")
	public String removeGiftWrapFromOrderEntry(@RequestParam("orderEntryPk") final String orderEntryPk, final Model model)
	{
		cartEntryService.removeGiftWrapFromOrderEntry(orderEntryPk);

		return REDIRECT_PREFIX + "/cart";
	}

	// to set gift-wrap options for color-box and setting the pk of that particular cart-order-entry
	@RequestMapping(value = "/giftWrapOptions", method = RequestMethod.GET)
	public String getGiftWrapOptions(@RequestParam("orderEntryPk") final String orderEntryPk, final Model model)
	{
		model.addAttribute("orderEntryPk", orderEntryPk);
		final List<GiftWrapModel> listOfGiftWraps = giftWrapService.getAllGiftWraps();
		model.addAttribute("listOfGiftWraps", listOfGiftWraps);
		return "pages/giftwrap/giftWrapOptions";
	}


}
