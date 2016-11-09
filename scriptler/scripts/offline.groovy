import jenkins.model.*
import hudson.model.*
import hudson.util.*
import hudson.node_monitors.*
import hudson.slaves.*
  
  jenkins = Jenkins.instance

  for (slave in jenkins.slaves) {
    def computer = slave.computer
    if (computer.name == target) {
      if (computer.isOffline()) {
        throw new hudson.AbortException("Target ${computer.name} is offline. Abort.")
      }
      println "Offline ${computer.name} for reboot"
      computer.doToggleOffline("Reboot to Kernel build ${kbuild}")
    }
  }