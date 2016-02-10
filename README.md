
# Gradle Frontend Plugin

## Description

Set of tasks which wraps common frontend-tools and provide its binaries.


## Tasks

### installnode

Download and install nodeJs and npm binaries

```
task frontBin(type: InstallNodeAndNpm) {
    description "shortcut for installing nodejs and npm binaries"
    installDirectoryPath = "/bin"
}

```

### npm

Executes npm command with provided arguments

```
task npmInstall(type: Npm) {
    description "shortcut for executing 'npm install'"
    npmArgs "install"
}
```


### grunt

Executes grunt command with provided arguments

```
task gruntBuild(type: Grunt) {
    description "shortcut for executing 'grunt build'"
    gruntArgs "build"
}
```


### gulp

Executes gulp command with provided arguments

```
task gulpTask(type: Gulp) {
}

```



## Configs (extension)
frontendConfig

eg
```
frontendConfig {
    workingDirectoryPath = "src/main/aem/jcr_root/etc/designs/example/clientlibs/"
    installDirectoryPath = "/bin"
}
```