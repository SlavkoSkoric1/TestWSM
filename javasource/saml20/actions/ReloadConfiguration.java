// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package saml20.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import saml20.implementation.SAMLFeedbackException;
import saml20.implementation.SAMLRequestHandler;

public class ReloadConfiguration extends CustomJavaAction<java.lang.Boolean>
{
	public ReloadConfiguration(IContext context)
	{
		super(context);
	}

	@java.lang.Override
	public java.lang.Boolean executeAction() throws Exception
	{
		// BEGIN USER CODE
        try {
            SAMLRequestHandler samlRequestHandler = SAMLRequestHandler.getInstance(this.getContext());
            samlRequestHandler.initServlet(getContext(), true);
        } catch (SAMLFeedbackException e) {
            if (("There is no active SSO Configuration available. Please review your configuration.").equals(e.getMessage()))
                return false;
            else
                throw e;
        }
        return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "ReloadConfiguration";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
