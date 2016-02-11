
# Gradle Frontend Plugin

![alt tag](https://travis-ci.org/subiron/gradle-frontend-plugin.svg?branch=master)

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


   Copyright 2016 Tomasz Misiewicz

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   
   Disclaimer:
   This plugin wraps core module of [frontend-maven-plugin](https://github.com/eirslett/frontend-maven-plugin)