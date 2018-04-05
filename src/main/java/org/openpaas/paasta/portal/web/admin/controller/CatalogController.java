package org.openpaas.paasta.portal.web.admin.controller;

import org.openpaas.paasta.portal.web.admin.common.Common;
import org.openpaas.paasta.portal.web.admin.common.Constants;
import org.openpaas.paasta.portal.web.admin.model.Catalog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 서비스 카탈로그, 개발 환경 카탈로그, 앱 템플릿 카탈로그 정보 조회 및 관리 등의 API 를 호출 하는 컨트롤러이다.
 *
 * @author 김도준
 * @version 1.0
 * @since 2016.07.04 최초작성
 */
@Controller
class CatalogController extends Common {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogController.class);

    private final String V2_URL = "/v2";

    /**
     * 카탈로그 메인페이지로 이동한다.
     *
     * @return ModelAndView(Spring 클래스)
     */
    @RequestMapping(value = {"/catalogs"}, method = RequestMethod.GET)
    public ModelAndView getCatalogMain() {
        return new ModelAndView() {{
            setViewName("/catalog/catalogMain");
        }};
    }


    /**
     * 카탈로그 메인페이지로 이동한다.
     *
     * @param tabName 탭 이름(String)
     * @return ModelAndView(Spring 클래스)
     */
    @RequestMapping(value = {"/catalogs/{tabName}"}, method = RequestMethod.GET)
    public ModelAndView getCatalogMain(@PathVariable("tabName") String tabName) {
        String reqTabName = Constants.TAB_NAME_STARTER;

        if (Constants.TAB_NAME_DEVELOP_PACK.equals(tabName)) reqTabName = Constants.TAB_NAME_DEVELOP_PACK;
        if (Constants.TAB_NAME_SERVICE_PACK.equals(tabName)) reqTabName = Constants.TAB_NAME_SERVICE_PACK;
        if (Constants.TAB_NAME_STARTER.equals(tabName)) reqTabName = Constants.TAB_NAME_STARTER;

        String finalReqTabName = reqTabName;
        return new ModelAndView() {{
            setViewName("/catalog/catalogMain");
            addObject("TAB_NAME", finalReqTabName);
        }};
    }


    /**
     * 앱 개발환경 저장페이지로 이동한다.
     *
     * @return ModelAndView(Spring 클래스)
     */
    @RequestMapping(value = {"/developpackForm"}, method = RequestMethod.GET)
    public ModelAndView getBuildPackForm() {
        return new ModelAndView() {{
            setViewName("/catalog/developPackForm");
            addObject("REQUEST_NO", "");
        }};
    }


    /**
     * 앱 개발환경 수정페이지로 이동한다.
     *
     * @param req HttpServletRequest(자바클래스)
     * @return ModelAndView(Spring 클래스)
     */
    @RequestMapping(value = {"/developpackForm"}, method = RequestMethod.POST)
    public ModelAndView getBuildPackForm(HttpServletRequest req) {
        return new ModelAndView() {{
            setViewName("/catalog/developPackForm");
            addObject("REQUEST_NO", req.getParameter("no"));
        }};
    }


    /**
     * 서비스 저장페이지로 이동한다.
     *
     * @return ModelAndView(Spring 클래스)
     */
    @RequestMapping(value = {"/servicepackForm"}, method = RequestMethod.GET)
    public ModelAndView getServicePackForm() {
        return new ModelAndView() {{
            setViewName("/catalog/servicePackForm");
            addObject("REQUEST_NO", "");
        }};
    }


    /**
     * 서비스 수정페이지로 이동한다.
     *
     * @param req HttpServletRequest(자바클래스)
     * @return ModelAndView(Spring 클래스)
     */
    @RequestMapping(value = {"/servicepackForm"}, method = RequestMethod.POST)
    public ModelAndView getServicePackForm(HttpServletRequest req) {

        return new ModelAndView() {{
            setViewName("/catalog/servicePackForm");
            addObject("REQUEST_NO", req.getParameter("no"));
        }};
    }


    /**
     * 앱 템플릿 저장페이지로 이동한다.
     *
     * @return ModelAndView(Spring 클래스)
     */
    @RequestMapping(value = {"/starterpackForm"}, method = RequestMethod.GET)
    public ModelAndView getStarterForm() {

        return new ModelAndView() {{
            setViewName("/catalog/starterPackForm");
            addObject("REQUEST_NO", "");
        }};
    }


    /**
     * 앱 템플릿 수정페이지로 이동한다.
     *
     * @param req HttpServletRequest(자바클래스)
     * @return ModelAndView(Spring 클래스)
     */
    @RequestMapping(value = {"/starterpackForm"}, method = RequestMethod.POST)
    public ModelAndView getStarterForm(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView();

        return new ModelAndView() {{
            setViewName("/catalog/starterPackForm");
            addObject("REQUEST_NO", req.getParameter("no"));
        }};
    }


    /**
     * 이미지 파일을 업로드한다.
     *
     * @param multipartFile MultipartFile(Spring 클래스)
     * @return Map(자바클래스)
     * @throws Exception Exception(자바클래스)
     */
    @RequestMapping(value = {"/v2/uploadThumbnailImage"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadThumbnailImage(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        //TODO 업로드 구현하면 수정해야함
//        return commonService.procRestTemplate("/catalog/uploadThumbnailImage", multipartFile, null);
        Map map = new HashMap();
        map.put("RESULT", Constants.RESULT_STATUS_SUCCESS);
        return map;
    }


    /**
     * 이미지 파일을 삭제한다.
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     */
    @RequestMapping(value = {V2_URL + "/deleteThumbnailImage"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteThumbnailImage(@RequestBody Catalog param) {
//        return commonService.procRestTemplate("/catalog/deleteThumbnailImage", HttpMethod.POST, param, null);
        //TODO 삭제 구현되면 수정해야함
        Map map = new HashMap();
        map.put("RESULT", Constants.RESULT_STATUS_SUCCESS);
        return map;
    }


    /**
     * 앱 샘플 파일을 업로드한다.
     *
     * @param multipartFile MultipartFile(Spring 클래스)
     * @return Map(자바클래스)
     * @throws Exception Exception(자바클래스)
     */
    @RequestMapping(value = {V2_URL + "/uploadAppSampleFile"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadAppSampleFile(@RequestParam("file") MultipartFile multipartFile) throws Exception {
//        return commonService.procRestTemplate("/catalog/uploadAppSampleFile", multipartFile, null);
//TODO 구현되면 수정해야함
        Map map = new HashMap();
        map.put("RESULT", Constants.RESULT_STATUS_SUCCESS);
        return map;
    }


    /**
     * 앱 샘플 파일을 삭제한다.
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     */
    @RequestMapping(value = {V2_URL + "/deleteAppSampleFile"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteAppSampleFile(@RequestBody Catalog param) {
//        return commonService.procRestTemplate("/catalog/deleteAppSampleFile", HttpMethod.POST, param, null);
        //TODO 구현되면 수정해야함
        Map map = new HashMap();
        map.put("RESULT", Constants.RESULT_STATUS_SUCCESS);
        return map;
    }










    /*
     * ------------------------------------------------------------------------------------조회
     */


    /**
     * 앱 템플릿명 목록을 조회한다.
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     */
    @GetMapping(V2_URL + "/starterpacks")
    @ResponseBody
    public Map<String, Object> getStarterNamesList(@ModelAttribute Catalog param) {
        return catalogService.getStarterPacksList(param);
    }


    /**
     * 앱 템플릿명 목록을 조회한다.
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     */
    @GetMapping(V2_URL + "/starterpacks/{no}")
    @ResponseBody
    public Map<String, Object> getStarterNames(@PathVariable("no") int no, @ModelAttribute Catalog param) {
        return catalogService.getStarterPack(no, param);
    }


    /**
     * 앱 템플릿명 목록을 조회한다.
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     */
    @GetMapping(V2_URL + "/starterpacks/count")
    @ResponseBody
    public Map<String, Object> getStarterNamesCount(@ModelAttribute Catalog param) {
        return catalogService.getStarterPackCount(param);
    }


    /**
     * 앱 개발환경 카탈로그 개수 조회
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     */
    @GetMapping(V2_URL + "/developpacks")
    @ResponseBody
    public Map<String, Object> getBuildPackCatalogList(@ModelAttribute Catalog param) {
        return catalogService.getDevelopPackCatalogList(param);
    }

    /**
     * 앱 개발환경 카탈로그 개수 조회
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     */
    @GetMapping(V2_URL + "/developpacks/{no}")
    @ResponseBody
    public Map<String, Object> getBuildPackCatalog(@PathVariable("no") int no, @ModelAttribute Catalog param) {
        return catalogService.getDevelopPackCatalog(no, param);
    }


    /**
     * 앱 개발환경 카탈로그 개수 조회
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     */
    @GetMapping(V2_URL + "/developpacks/count")
    @ResponseBody
    public Map<String, Object> getBuildPackCatalogCount(@ModelAttribute Catalog param) {
        return catalogService.getDevelopPackCatalogCount(param);
    }

    /**
     * 서비스 카탈로그 목록을 조회한다.
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     */

    @GetMapping(V2_URL + "/servicepacks")
    @ResponseBody
    public Map<String, Object> getServicePackCatalogList(@ModelAttribute Catalog param) {
        return catalogService.getServicePackCatalogList(param);
    }


    /**
     * 서비스 카탈로그 목록을 조회한다.
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     */
    @GetMapping(V2_URL + "/servicepacks/{no}")
    @ResponseBody
    public Map<String, Object> getServicePackCatalog(@PathVariable("no") int no, @ModelAttribute Catalog param) {
        return catalogService.getServicePackCatalog(no, param);
    }

    /**
     * 서비스 카탈로그 목록을 조회한다.
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     */
    @GetMapping(V2_URL + "/servicepacks/count")
    @ResponseBody
    public Map<String, Object> getServicePackCatalogCount(@ModelAttribute Catalog param) {
        return catalogService.getServicePackCatalogCount(param);
    }
    /*
     * ------------------------------------------------------------------------------------조회 끝
     */


    /*
     * ------------------------------------------------------------------------------------추가
     */

    /**
     * 스타터 팩을 저장한다.
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     * @throws Exception Exception(자바클래스)
     */
    @PostMapping(value = {V2_URL + "/starterpacks"})
    @ResponseBody
    public Map<String, Object> insertStarterPackCatalog(@RequestBody Catalog param) throws Exception {
        LOGGER.info(param.toString());
        return catalogService.insertStarterPack(param);
    }

    /**
     * 빌드 팩을 저장한다.
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     * @throws Exception Exception(자바클래스)
     */
    @PostMapping(value = {V2_URL + "/developpacks"})
    @ResponseBody
    public Map<String, Object> insertBuildPackCatalog(@RequestBody Catalog param) throws Exception {
        LOGGER.info(param.toString());
        return catalogService.insertDevelopPackCatalog(param);
    }

    /**
     * 서비스 팩을 저장한다.
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     * @throws Exception Exception(자바클래스)
     */
    @PostMapping(value = {V2_URL + "/servicepacks"})
    @ResponseBody
    public Map<String, Object> insertServicePack(@RequestBody Catalog param) throws Exception {
        return catalogService.insertServicePackCatalog(param);
    }


    /*
     * ------------------------------------------------------------------------------------추가 끝
     */



    /*
     * ------------------------------------------------------------------------------------수정
     */

    /**
     * 스타터 팩을 수정한다.
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     * @throws Exception Exception(자바클래스)
     */
    @PutMapping(value = {V2_URL + "/starterpacks/{no}"})
    @ResponseBody
    public Map<String, Object> updateStarterPackCatalog(@PathVariable int no, @RequestBody Catalog param) throws Exception {
        LOGGER.info(param.toString());
        return catalogService.updateStarterPack(no, param);
    }

    /**
     * 빌드 팩을 수정한다.
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     * @throws Exception Exception(자바클래스)
     */
    @PutMapping(value = {V2_URL + "/developpacks/{no}"})
    @ResponseBody
    public Map<String, Object> updateBuildPackCatalog(@PathVariable int no, @RequestBody Catalog param) throws Exception {
        return catalogService.updateDevelopPackCatalog(no, param);
    }

    /**
     * 서비스 팩을 수정한다.
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     * @throws Exception Exception(자바클래스)
     */
    @PutMapping(value = {V2_URL + "/servicepacks/{no}"})
    @ResponseBody
    public Map<String, Object> updateServicePack(@PathVariable int no, @RequestBody Catalog param) throws Exception {
        return catalogService.updateServicePackCatalog(no, param);
    }

    /*
     * ------------------------------------------------------------------------------------수정 끝
     */

    /*
     * ------------------------------------------------------------------------------------삭제
     */

    /**
     * 스타터 팩을 삭제한다.
     *
     * @return Map(자바클래스)
     */
    @DeleteMapping(value = {V2_URL + "/starterpacks/{no}"})
    @ResponseBody
    public Map<String, Object> deleteStarterPackCatalog(@PathVariable int no) {
        return catalogService.deleteStarterPack(no);
    }


    /**
     * 빌드 팩을 삭제한다.
     *
     * @return Map(자바클래스)
     */
    @DeleteMapping(value = {V2_URL + "/developpacks/{no}"})
    @ResponseBody
    public Map<String, Object> deleteBuildPackCatalog(@PathVariable int no) {
        return catalogService.deleteBuildPackCatalog(no);
    }


    /**
     * 서비스 팩을 삭제한다.
     *
     * @return Map(자바클래스)
     */
    @DeleteMapping(value = {V2_URL + "/servicepacks/{no}"})
    @ResponseBody
    public Map<String, Object> deleteServicePackCatalog(@PathVariable int no) {
        return catalogService.deleteServicePackCatalog(no);
    }


    /**
     * 앱 개발환경 카탈로그 삭제 가능여부를 조회한다.
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     */
    @RequestMapping(value = {"/getCheckDeleteBuildPackCatalogCount"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getCheckDeleteBuildPackCatalogCount(@RequestBody Catalog param) {
        return commonService.procRestTemplate("/catalog/getCheckDeleteBuildPackCatalogCount", HttpMethod.POST, param, null);
    }


    /**
     * 서비스 카탈로그 삭제 가능여부를 조회한다.
     *
     * @param param Catalog(모델클래스)
     * @return Map(자바클래스)
     */
    @RequestMapping(value = {"/getCheckDeleteServicePackCatalogCount"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getCheckDeleteServicePackCatalogCount(@RequestBody Catalog param) {
        return commonService.procRestTemplate("/catalog/getCheckDeleteServicePackCatalogCount", HttpMethod.POST, param, null);
    }


    /*
     * ------------------------------------------------------------------------------------삭제 끝
     */


}
