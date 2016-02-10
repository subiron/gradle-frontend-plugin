package org.misiewicz.frontend.extensions


class FrontendExtension {
    /**
     * The base directory for running all Node commands. (Usually the directory that contains package.json)
     */
    String workingDirectoryPath
    /**
     * The directory for storing node and npm binaries
     */
    String installDirectoryPath

    String nodeVersion

    String npmVersion

}
