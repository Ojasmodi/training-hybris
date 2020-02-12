/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at 10 Feb, 2020 1:32:15 PM                     ---
 * ----------------------------------------------------------------
 */
package org.training.core.jalo;

import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.media.Media;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.training.core.constants.TrainingCoreConstants;

/**
 * Generated class for type {@link org.training.core.jalo.GiftWrap GiftWrap}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedGiftWrap extends GenericItem
{
	/** Qualifier of the <code>GiftWrap.giftWrapType</code> attribute **/
	public static final String GIFTWRAPTYPE = "giftWrapType";
	/** Qualifier of the <code>GiftWrap.code</code> attribute **/
	public static final String CODE = "code";
	/** Qualifier of the <code>GiftWrap.cost</code> attribute **/
	public static final String COST = "cost";
	/** Qualifier of the <code>GiftWrap.description</code> attribute **/
	public static final String DESCRIPTION = "description";
	/** Qualifier of the <code>GiftWrap.giftWrapImage</code> attribute **/
	public static final String GIFTWRAPIMAGE = "giftWrapImage";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(GIFTWRAPTYPE, AttributeMode.INITIAL);
		tmp.put(CODE, AttributeMode.INITIAL);
		tmp.put(COST, AttributeMode.INITIAL);
		tmp.put(DESCRIPTION, AttributeMode.INITIAL);
		tmp.put(GIFTWRAPIMAGE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.code</code> attribute.
	 * @return the code
	 */
	public String getCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.code</code> attribute.
	 * @return the code
	 */
	public String getCode()
	{
		return getCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.code</code> attribute. 
	 * @param value the code
	 */
	public void setCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.code</code> attribute. 
	 * @param value the code
	 */
	public void setCode(final String value)
	{
		setCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.cost</code> attribute.
	 * @return the cost
	 */
	public Double getCost(final SessionContext ctx)
	{
		return (Double)getProperty( ctx, COST);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.cost</code> attribute.
	 * @return the cost
	 */
	public Double getCost()
	{
		return getCost( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.cost</code> attribute. 
	 * @return the cost
	 */
	public double getCostAsPrimitive(final SessionContext ctx)
	{
		Double value = getCost( ctx );
		return value != null ? value.doubleValue() : 0.0d;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.cost</code> attribute. 
	 * @return the cost
	 */
	public double getCostAsPrimitive()
	{
		return getCostAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.cost</code> attribute. 
	 * @param value the cost
	 */
	public void setCost(final SessionContext ctx, final Double value)
	{
		setProperty(ctx, COST,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.cost</code> attribute. 
	 * @param value the cost
	 */
	public void setCost(final Double value)
	{
		setCost( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.cost</code> attribute. 
	 * @param value the cost
	 */
	public void setCost(final SessionContext ctx, final double value)
	{
		setCost( ctx,Double.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.cost</code> attribute. 
	 * @param value the cost
	 */
	public void setCost(final double value)
	{
		setCost( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.description</code> attribute.
	 * @return the description
	 */
	public String getDescription(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedGiftWrap.getDescription requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, DESCRIPTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.description</code> attribute.
	 * @return the description
	 */
	public String getDescription()
	{
		return getDescription( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.description</code> attribute. 
	 * @return the localized description
	 */
	public Map<Language,String> getAllDescription(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,DESCRIPTION,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.description</code> attribute. 
	 * @return the localized description
	 */
	public Map<Language,String> getAllDescription()
	{
		return getAllDescription( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.description</code> attribute. 
	 * @param value the description
	 */
	public void setDescription(final SessionContext ctx, final String value)
	{
		if ( ctx == null) 
		{
			throw new JaloInvalidParameterException( "ctx is null", 0 );
		}
		if( ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedGiftWrap.setDescription requires a session language", 0 );
		}
		setLocalizedProperty(ctx, DESCRIPTION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.description</code> attribute. 
	 * @param value the description
	 */
	public void setDescription(final String value)
	{
		setDescription( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.description</code> attribute. 
	 * @param value the description
	 */
	public void setAllDescription(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,DESCRIPTION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.description</code> attribute. 
	 * @param value the description
	 */
	public void setAllDescription(final Map<Language,String> value)
	{
		setAllDescription( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.giftWrapImage</code> attribute.
	 * @return the giftWrapImage
	 */
	public Media getGiftWrapImage(final SessionContext ctx)
	{
		return (Media)getProperty( ctx, GIFTWRAPIMAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.giftWrapImage</code> attribute.
	 * @return the giftWrapImage
	 */
	public Media getGiftWrapImage()
	{
		return getGiftWrapImage( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.giftWrapImage</code> attribute. 
	 * @param value the giftWrapImage
	 */
	public void setGiftWrapImage(final SessionContext ctx, final Media value)
	{
		setProperty(ctx, GIFTWRAPIMAGE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.giftWrapImage</code> attribute. 
	 * @param value the giftWrapImage
	 */
	public void setGiftWrapImage(final Media value)
	{
		setGiftWrapImage( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.giftWrapType</code> attribute.
	 * @return the giftWrapType
	 */
	public EnumerationValue getGiftWrapType(final SessionContext ctx)
	{
		return (EnumerationValue)getProperty( ctx, GIFTWRAPTYPE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>GiftWrap.giftWrapType</code> attribute.
	 * @return the giftWrapType
	 */
	public EnumerationValue getGiftWrapType()
	{
		return getGiftWrapType( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.giftWrapType</code> attribute. 
	 * @param value the giftWrapType
	 */
	public void setGiftWrapType(final SessionContext ctx, final EnumerationValue value)
	{
		setProperty(ctx, GIFTWRAPTYPE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>GiftWrap.giftWrapType</code> attribute. 
	 * @param value the giftWrapType
	 */
	public void setGiftWrapType(final EnumerationValue value)
	{
		setGiftWrapType( getSession().getSessionContext(), value );
	}
	
}
