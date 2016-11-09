import jenkins.model.*
import hudson.model.*
import hudson.util.*
import hudson.node_monitors.*
import hudson.slaves.*
  
  jenkins = Jenkins.instance

  for (slave in jenkins.slaves) {
    def computer = slave.computer
    if (computer.name == target) {
      if (computer.isOnline()) {
        throw new hudson.AbortException("Target ${computer.name} is already online. Abort.")
      }
      println "Online ${computer.name} after reboot"
      computer.doToggleOffline("Online after Reboot to Kernel build ${kbuild}")
      computer.waitUntilOnline()
    }
  }
