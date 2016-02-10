package org.misiewicz.frontend.task

import org.misiewicz.frontend.extensions.FrontendExtension
import com.github.eirslett.maven.plugins.frontend.lib.FrontendPluginFactory
import com.github.eirslett.maven.plugins.frontend.lib.ProxyConfig
import org.apache.commons.collections.ListUtils
import org.apache.commons.lang3.StringUtils
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input

abstract class AbstractFrontEndTask extends DefaultTask {

    protected String PLUGIN_GROUP = "Frontend"

    def static final NPV_VERSION_DEFAULT =  "3.5.0"

    def static final NODE_VERSION_DEFAULT = "v5.5.0"

    def installDirectoryPath

    def workingDirectoryPath

    @Input
    def nodeVersion

    @Input
    def npmVersion

    FrontendPluginFactory factory

    ProxyConfig proxyConfig = new ProxyConfig(ListUtils.EMPTY_LIST);

    public AbstractFrontEndTask() {
        group PLUGIN_GROUP
    }
    
    FrontendExtension getConfig() {
        project.frontendConfig as FrontendExtension
    }

    File getWorkingDirectory() {
        if (workingDirectoryPath == null) {
            if (config != null && !config.workingDirectoryPath != null) {
                workingDirectoryPath = config.workingDirectoryPath
            }
        }

        if (workingDirectoryPath == null) {
            workingDirectoryPath = project.getProjectDir().getPath();
        }

        project.file(workingDirectoryPath)
    }

    File getInstallDirectory() {
        if (installDirectoryPath == null) {
            if (config != null && !config.installDirectoryPath != null) {
                installDirectoryPath = config.installDirectoryPath
            }
        }
        if (installDirectoryPath == null) {
            installDirectoryPath = "${project.buildDir.getPath()}/frontend/bin";
        }
        project.file(installDirectoryPath)
    }

    String getNpmVersion() {
        if (StringUtils.isNotBlank(npmVersion)) {
            return npmVersion
        }

        FrontendExtension params = (FrontendExtension) project.frontendConfig;
        if (params != null && StringUtils.isNotBlank(params.npmVersion)) {
            return params.npmVersion
        }

        NPV_VERSION_DEFAULT
    }

    String getNodeVersion() {
        if (StringUtils.isNotBlank(nodeVersion)) {
            return nodeVersion
        }

        FrontendExtension params = (FrontendExtension) project.frontendConfig;
        if (params != null && StringUtils.isNotBlank(params.nodeVersion)) {
            return params.nodeVersion
        }

        NODE_VERSION_DEFAULT
    }

    FrontendPluginFactory getFactory() {
        if (factory == null) {
            factory = new FrontendPluginFactory(getWorkingDirectory(), getInstallDirectory());
        }

        factory
    }
}
