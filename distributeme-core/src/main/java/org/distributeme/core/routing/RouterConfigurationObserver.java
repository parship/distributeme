package org.distributeme.core.routing;

/**
 * If some object wants to react to router configuration changes, it can observe router configuration via this interface.
 * Method 'routerConfigurationChange' will be called on every change, routerConfigurationInitialChange only on initial configuration and
 * routerConfigurationFollowupChange only upon reconfiguration.
 * Note: due to the nature of the service initialization, a service will never be able to get initial router configuration event. Instead it should only listen to followup change events.
 *
 * @author lrosenberg
 * @since 23.09.15 22:55
 * @version $Id: $Id
 */
public interface RouterConfigurationObserver {
	/**
	 * Called upon FIRST configuration of the router.
	 *
	 * @param configuration a {@link org.distributeme.core.routing.GenericRouterConfiguration} object.
	 */
	void routerConfigurationInitialChange(GenericRouterConfiguration configuration);

	/**
	 * Called upon
	 *
	 * @param configuration a {@link org.distributeme.core.routing.GenericRouterConfiguration} object.
	 */
	void routerConfigurationFollowupChange(GenericRouterConfiguration configuration);

	/**
	 * Called after every router configuration change.
	 *
	 * @param configuration a {@link org.distributeme.core.routing.GenericRouterConfiguration} object.
	 */
	void routerConfigurationChange(GenericRouterConfiguration configuration);
}
