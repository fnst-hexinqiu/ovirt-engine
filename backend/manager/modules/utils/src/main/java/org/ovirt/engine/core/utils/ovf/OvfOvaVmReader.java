package org.ovirt.engine.core.utils.ovf;

import org.ovirt.engine.core.common.businessentities.ArchitectureType;
import org.ovirt.engine.core.common.businessentities.VM;
import org.ovirt.engine.core.common.businessentities.storage.FullEntityOvfData;
import org.ovirt.engine.core.common.osinfo.OsRepository;
import org.ovirt.engine.core.utils.ovf.xml.XmlDocument;

public class OvfOvaVmReader extends OvfOvaReader {

    private VM vm;

    public OvfOvaVmReader(XmlDocument document, FullEntityOvfData fullEntityOvfData, VM vm, OsRepository osRepository) {
        super(document, fullEntityOvfData, vm.getStaticData(), osRepository);
        this.vm = vm;
    }

    @Override
    protected void setClusterArch(ArchitectureType arch) {
        vm.setClusterArch(arch);
    }
}
