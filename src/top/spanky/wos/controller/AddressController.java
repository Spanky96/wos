package top.spanky.wos.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import top.spanky.wos.Constants;
import top.spanky.wos.json.MyJsonConfig;
import top.spanky.wos.model.Address;
import top.spanky.wos.service.AddressService;

@Controller
@RequestMapping(Constants.APP_URL_PREFIX)
public class AddressController extends BaseController {

    private final Logger logger = Logger.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/address/get/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public JSONArray getUserAddress(@PathVariable int userId) {
        JSONArray address = JSONArray.fromObject(addressService.getAllAddressByUserId(userId),
                MyJsonConfig.getMyJsonConfig());
        return address;
    }

    @RequestMapping(value = "/address/add", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap addAddress(@RequestBody String addressStr) {
        JSONObject obj = JSONObject.fromObject(addressStr);
        Address newAddress = (Address) JSONObject.toBean(obj, Address.class);
        ModelMap modelMap = new ModelMap();
        boolean result = addressService.add(newAddress);
        if (result) {
            modelMap.put("result", SUCCESS);
            modelMap.put("address", newAddress);
        } else {
            modelMap.put("result", FAIL);
        }
        return modelMap;
    }

    @RequestMapping(value = "/address/update", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap updateAddress(@RequestBody String addressStr) {
        JSONObject obj = JSONObject.fromObject(addressStr);
        Address newAddress = (Address) JSONObject.toBean(obj, Address.class);
        ModelMap modelMap = new ModelMap();
        boolean result = addressService.update(newAddress);
        if (result) {
            modelMap.put("result", SUCCESS);
        } else {
            modelMap.put("result", FAIL);
        }
        return modelMap;
    }

    @RequestMapping(value = "/address/delete/{addressId}", method = RequestMethod.GET)
    @ResponseBody
    public ModelMap deleteAddress(@PathVariable int addressId) {
        ModelMap modelMap = new ModelMap();
        boolean result = addressService.deleteById(addressId);
        if (result) {
            modelMap.put("result", SUCCESS);
        } else {
            modelMap.put("result", FAIL);
        }
        return modelMap;
    }
}
