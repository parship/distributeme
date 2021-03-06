package org.distributeme.annotation;

import org.distributeme.core.routing.Router;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Route class.</p>
 *
 * @author another
 * @version $Id: $Id
 */
@Retention (RetentionPolicy.SOURCE)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface Route {
	/**
	 * Class implementing the router interface.
	 * @return
	 */
	Class<? extends Router> routerClass();
	/**
	 * Custom parameter which is used for proper router initialization/customization. Default value is empty string.
	 * @return
	 */
	String routerParameter() default  "";

	/**
	 * Alternative to router parameter a configuration name can be provided. The configuration should be router specific.
	 * If both, configurationName and routerParameter are provided, configurationName overrides.
	 * @return
	 */
	String configurationName() default "";

}
