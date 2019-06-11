package com.me.controller;

import com.me.pojo.UserInfo;
import com.me.service.PersonalService;
import com.me.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class PersonalController {

    @Autowired
    PersonalService personalService;

    /**
     * 根据用户id查询用户信息，用于展示 personal_center.html 页面
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectUserInfo", method = RequestMethod.POST)
    public Object selectUserInfo(HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

        int userId = userInfo.getUser_id();
        UserInfoDto userInfoDto = personalService.selectCareByAttentionsAndFans(userId);
        userInfoDto.setUserInfo(userInfo);

        return userInfoDto;
    }

    /**
     * 根据用户 id 查询用户收藏夹信息，用于展示 collect_center.html 页面
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectFavoritesByUserId", method = RequestMethod.POST)
    public Object selectFavoritesByUserId(HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        int userId = userInfo.getUser_id();
        return personalService.selectFavoritesByUserId(userId);
    }

    /**
     * 根据收藏夹id查询收藏夹中内容
     *
     * @param favorites_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectFavoritesByFavoritesId", method = RequestMethod.GET)
    public Object selectFavoritesByFavoritesId(@RequestParam int favorites_id) {
        return personalService.selectFavoritesByFavoritesId(favorites_id);
    }

    /**
     * 根据用户 id 查询用户的关注信息，用于展示 attention_center.html 页面
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectCareByUserId", method = RequestMethod.GET)
    public Object selectCareByUserId(HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        return personalService.selectCareByUserId(user_id);
    }

    /**
     * 取消关注
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "noCare",method = RequestMethod.GET)
    public Object noCare(String uf_id,HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        personalService.noCare(user_id,uf_id);
        return null;
    }

    /**
     * 关注
     * @param uf_id
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "myCare",method = RequestMethod.GET)
    public Object myCare(String uf_id,HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        personalService.myCare(user_id,uf_id);
        return null;
    }


    /**
     * 根据用户 id 查询该用户被那些用户关注，用于展示 fan_center.html 页面
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectCareByUserFromId", method = RequestMethod.GET)
    public Object selectCareByUserFromId(HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        int user_id = userInfo.getUser_id();
        List<UserInfo> userInfoList = personalService.selectCareByUserFromId(user_id);
        return userInfoList;
    }

    /**
     * 上传头像图片
     *
     * @param dropzFile
     * @param request
     * @return
     */
    private static String userInfoUrl;
    private static String userInfoUrlPath;

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Map<String, Object> upload(MultipartFile dropzFile, HttpServletRequest request) {

        Map<String, Object> result = new HashMap<String, Object>();

        // 获取上传的原始文件名
        String fileName = dropzFile.getOriginalFilename();
        // 设置文件上传路径
        String filePath = request.getSession().getServletContext().getRealPath("/image");
        // 获取文件后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());

        // 判断并创建上传用的文件夹
        File destFile = new File(filePath);
        if (!destFile.exists()) {
            destFile.mkdirs();
        }
        // 重新设置文件名为 UUID，以确保唯一
        destFile = new File(filePath, UUID.randomUUID() + fileSuffix);
        userInfoUrl = destFile.getName();
        userInfoUrlPath = destFile.toString();
        if (!destFile.exists()) {
            try {
                destFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            // 写入文件
            dropzFile.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回 JSON 数据，这里只带入了文件名
        result.put("fileName", destFile.getName());
        return result;
    }

    /**
     * 更改用户的头像
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateUserInfoUrl", method = RequestMethod.POST)
    public Object updateUserInfoUrl(HttpSession session) {

        if (!userInfoUrl.equals("") && userInfoUrl != null) {

            UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
            userInfo.setUrl(userInfoUrl);
            boolean b = personalService.updateUserInfoByUserIdToUrl(userInfo);
            userInfoUrl = "";
            userInfoUrlPath = "";
            return b;
        }
        return false;
    }

    /**
     * 取消更改图片并删除上传的图片
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cancelUserInfoUrl", method = RequestMethod.POST)
    public Object cancelUserInfoUrl() {
        userInfoUrl = "";
        if (!userInfoUrlPath.equals("") && userInfoUrlPath != null) {
            File file = new File(userInfoUrlPath);
            boolean delete = file.delete();
            userInfoUrlPath = "";
            return delete;
        }
        return false;
    }

}
