/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 31 Jan, 2020 11:25:15 AM                    ---
 * ----------------------------------------------------------------
 */
package org.training.core.jalo;

import de.hybris.platform.cms2.jalo.contents.components.SimpleCMSComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.media.Media;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.training.core.constants.TrainingCoreConstants;
import org.training.core.jalo.GiftWrap;

/**
 * Generated class for type {@link org.training.core.jalo.GiftWrapComponent GiftWrapComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedGiftWrapComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>GiftWrapComponent.listOfGiftWraps</code> attribute **/
	public static final String LISTOFGIFTWRAPS = "listOfGiftWraps";
	/** Qualifier of the <code>GiftWrapComponent.giftWrapImage</code> attribute **/
	public static final String GIFTWRAPIMAGE = "giftWrapImage";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(LISTOFGIFTWRAPS, AttributeMode.INITIAL);
		tmp.put(GIFTWRAPIMAGE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrapComponent.giftWrapImage</code> attribute.
	 * @return the giftWrapImage
	 */
	public Media getGiftWrapImage(final SessionContext ctx)
	{
		return (Media)getProperty( ctx, GIFTWRAPIMAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrapComponent.giftWrapImage</code> attribute.
	 * @return the giftWrapImage
	 */
	public Media getGiftWrapImage()
	{
		return getGiftWrapImage( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrapComponent.giftWrapImage</code> attribute. 
	 * @param value the giftWrapImage
	 */
	public void setGiftWrapImage(final SessionContext ctx, final Media value)
	{
		setProperty(ctx, GIFTWRAPIMAGE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrapComponent.giftWrapImage</code> attribute. 
	 * @param value the giftWrapImage
	 */
	public void setGiftWrapImage(final Media value)
	{
		setGiftWrapImage( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrapComponent.listOfGiftWraps</code> attribute.
	 * @return the listOfGiftWraps
	 */
	public List<GiftWrap> getListOfGiftWraps(final SessionContext ctx)
	{
		List<GiftWrap> coll = (List<GiftWrap>)getProperty( ctx, LISTOFGIFTWRAPS);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrapComponent.listOfGiftWraps</code> attribute.
	 * @return the listOfGiftWraps
	 */
	public List<GiftWrap> getListOfGiftWraps()
	{
		return getListOfGiftWraps( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrapComponent.listOfGiftWraps</code> attribute. 
	 * @param value the listOfGiftWraps
	 */
	public void setListOfGiftWraps(final SessionContext ctx, final List<GiftWrap> value)
	{
		setProperty(ctx, LISTOFGIFTWRAPS,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrapComponent.listOfGiftWraps</code> attribute. 
	 * @param value the listOfGiftWraps
	 */
	public void setListOfGiftWraps(final List<GiftWrap> value)
	{
		setListOfGiftWraps( getSession().getSessionContext(), value );
	}
	
}
