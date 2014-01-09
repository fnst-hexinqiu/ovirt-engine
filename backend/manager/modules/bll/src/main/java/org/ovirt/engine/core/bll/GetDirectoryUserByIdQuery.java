package org.ovirt.engine.core.bll;

import org.ovirt.engine.core.bll.adbroker.AdActionType;
import org.ovirt.engine.core.bll.adbroker.LdapBroker;
import org.ovirt.engine.core.bll.adbroker.LdapFactory;
import org.ovirt.engine.core.bll.adbroker.LdapSearchByIdParameters;
import org.ovirt.engine.core.common.businessentities.LdapUser;
import org.ovirt.engine.core.common.queries.DirectoryIdQueryParameters;
import org.ovirt.engine.core.common.utils.ExternalId;

public class GetDirectoryUserByIdQuery<P extends DirectoryIdQueryParameters> extends QueriesCommandBase<P> {

    public GetDirectoryUserByIdQuery(P parameters) {
        super(parameters);
    }

    @Override
    protected void executeQueryCommand() {
        String domain = getParameters().getDomain();
        ExternalId id = getParameters().getId();
        LdapBroker broker = LdapFactory.getInstance(domain);
        LdapUser user = (LdapUser) broker.runAdAction(
                AdActionType.GetAdUserByUserId,
                new LdapSearchByIdParameters(domain, id)
        ).getReturnValue();
        getQueryReturnValue().setReturnValue(user);
    }

}
