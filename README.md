## JZOS with Maven Example

Example showing how to develop Java applications for z/OS with Maven and the [JZOS library](https://www.ibm.com/docs/en/semeru-runtime-ce-z/11?topic=guide-managing-jzos-dependencies-by-using-maven) using VS Code.

## Preparing your z/OS system

- Get access to a z/OS system with Java 11 or 17 installed. Make sure this Java is configured for your PATH and JAVA_HOME. We recommend [IBM Wazi as a Service](https://www.ibm.com/cloud/wazi-as-a-service) systems.
- Configure access to ssh; ideally password-less ssh
- Make sure you can use either [z/OSMF or RSE API on your system](https://ibm.github.io/zopeneditor-about/Docs/setup_integration.html) so it can be used with Zowe CLI and Zowe Explorer.
- Create a directory for the Java executable to be uploaded. Default is `~/projects/java`. Adjust the script of you choose a different path.
- Open ports on your z/OS system or VPC subnet when using Wazi as a Service, so you can use RSE API or z/OSMF, ssh, as well as port 8000 for the debugger.

## Setting up VS Code

- Install [Microsoft Visual Studio Code](https://code.visualstudio.com/) version 1.83.1 or newer
- Install [IBM Semeru Java Development Kit](https://developer.ibm.com/languages/java/semeru-runtimes/downloads/) v11 or 17. Make sure this Java is configured for your PATH and JAVA_HOME.
- Install [Maven](https://maven.apache.org/download.cgi).
- Clone and open this repository and install all recommend VS extensions (see popup dialog).
- To use the automation scripts install [Zowe CLI](https://docs.zowe.org/stable/user-guide/cli-installcli/) and create a [Zowe CLI profile in VS Code Zowe Explorer](https://ibm.github.io/zopeneditor-about/Docs/connect_to_zos_with_zowe_explorer_e2e.html) to your system and ensure it works.
- On Windows make Git Bash or a comparable Bash shell your default terminal.

## Building the samples

Use the Maven tools provided by the VS Code extensions you installed or manually build the application with 

```bash
mvn package
```

Check the [pom.xml](./pom.xml) file for what is currently being build. The result will be a see a [target/jzos-samples-1.0-SNAPSHOT.jar](./target/) jar file that uses the [PdsLister](./src/main/java/com/ibm/jzos/sample/PdsLister.java) as the main class. If you want to work with different JZOS examples modify the entries here.

## Running the example

You can use Zowe Explorer to manually copy the jar file and run it on z/OS via ssh, for example

```bash
java -jar jzos-samples-1.0-SNAPSHOT.jar "//SAMPLE.COBOL"
```

There is also sample script ([./scripts/run-zos.sh](./scripts/run-zos.sh)) and VS Code task that can do these steps all for you. Assuming you can run bash-based scripts, have all the recommended extensions installed and Zowe CLI/Explorer configured you can just run the the task "Run Java program on z/OS", which will prompt you for the jar file to use in the Maven `targets` folder and the input parameter for the program. Then it will use Zowe CLI to upload the jar file to Unix System Services and run the program with the parameter. Depending if you are using Zowe with RSE or z/OSMF you need to adjust the script to use the right settings. See the comments in the script.

## Running a debug session for the example

To run a debug session for your program you can use the same script, but start it via the task "Debug Java program on z/OS", which will start it in Debug mode. Set a breakpoint in the source code, e.g. in line 33 in [./src/main/java/com/ibm/jzos/sample/PdsLister.java](./src/main/java/com/ibm/jzos/sample/PdsLister.java). Edit the debug launch called "Debug (Attach to z/OS)" in [./.vscode/launch.json](./.vscode/launch.json) to provide your z/OS system's IP address. Then run the launch to connect to you waiting debug session.
