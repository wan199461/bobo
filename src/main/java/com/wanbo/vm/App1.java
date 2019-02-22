package com.wanbo.vm;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.alibaba.fastjson.JSON;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

public class App1 {

    public static void main(String[] args) {

        List<VirtualMachineDescriptor> virtuals = VirtualMachine.list();
        String pids = "752";

        VirtualMachine virtualMachine = null;
        Properties agenProperties = null;
        try {
            virtualMachine = VirtualMachine.attach(pids);
            
//            virtualMachine.
            
            agenProperties = virtualMachine.getAgentProperties();
        } catch (AttachNotSupportedException | IOException e) {
            e.printStackTrace();
        }

        System.out.println(JSON.toJSONString(virtuals));
        System.out.println(JSON.toJSONString(agenProperties));

        List<VirtualMachineDescriptor> virtualMatches = virtualMachine.list();
        System.out.println(JSON.toJSONString(virtualMatches));
    }

}
