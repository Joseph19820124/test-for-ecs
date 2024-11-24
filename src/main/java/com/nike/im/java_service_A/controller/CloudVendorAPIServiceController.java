package com.nike.im.java_service_A.controller;

import com.nike.im.java_service_A.dto.CloudVendor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIServiceController {
    @GetMapping("/{vendorId}")
    public CloudVendor getCloudVendor(@PathVariable String vendorId) {
        return new CloudVendor(vendorId, "vendo41", "Address1", "");
    }

    @GetMapping("/{id}")
    public CloudVendor getMockCloudVendor(@PathVariable String id) {
        return new CloudVendor(id, "vendor2", "Address2", "13564442916");
    }

    @GetMapping("/greeting")
    public String greeting(){
        return "Hello";
    }

}
