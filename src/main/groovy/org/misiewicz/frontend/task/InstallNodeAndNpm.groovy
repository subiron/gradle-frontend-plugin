package org.misiewicz.frontend.task;

import com.github.eirslett.maven.plugins.frontend.lib.InstallationException;
import com.github.eirslett.maven.plugins.frontend.lib.NodeAndNPMInstaller;
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction;


public class InstallNodeAndNpm extends AbstractFrontEndTask {

    public InstallNodeAndNpm() {
        super()
        description 'Installs Node and Npm binaries to provided location'
    }

    @Input
    String nodeDownloadRoot = NodeAndNPMInstaller.DEFAULT_NODEJS_DOWNLOAD_ROOT

    @Input
    String npmDownloadRoot = NodeAndNPMInstaller.DEFAULT_NPM_DOWNLOAD_ROOT

    @OutputDirectory
    def getDir() {
        return getInstallDirectory()
    }


    @TaskAction
    def run() throws InstallationException {
        logger.info "downloading node and npm into ${getInstallDirectory()}"
        getFactory().getNodeAndNPMInstaller(proxyConfig).install(nodeVersion, npmVersion, nodeDownloadRoot, npmDownloadRoot);

    }
}
