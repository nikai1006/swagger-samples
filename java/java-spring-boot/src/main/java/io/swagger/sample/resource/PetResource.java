package io.swagger.sample.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.sample.data.PetData;
import io.swagger.sample.exception.NotFoundException;
import io.swagger.sample.models.Pet;
import io.swagger.sample.models.User;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetResource extends AbstractResource {

    private static PetData data = new PetData();

    @ApiOperation(notes = "Returns a pet when 0 < ID <= 10.  ID > 10 or non-integers will simulate API error conditions", value = "Find pet by ID", nickname = "getPetById",
        tags = {"Pets"})
    @ApiResponses({
        @ApiResponse(code = 200, message = "Nice!", response = Pet.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = io.swagger.sample.models.ApiResponse.class),
        @ApiResponse(code = 404, message = "Pet not found", response = io.swagger.sample.models.ApiResponse.class)
    })
    @RequestMapping(value = "/pets/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Pet> getPetById(
        @ApiParam(value = "ID of pet that needs to be fetched", allowableValues = "range[1,10]", required = true) @PathVariable("id") Integer petId)
        throws Exception {
        Pet pet = data.getPetById(petId);
        if (pet != null) {
            return ResponseEntity.ok().body(pet);
        } else {
            throw new NotFoundException(io.swagger.sample.models.ApiResponse.ERROR, "Pet " + petId + " not found");
        }
    }


    @ApiOperation(value = "query all users", notes = "查询所有用户")
    @GetMapping(value = "/users/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<User> queryAll() {
        return null;
    }

    @ApiOperation(notes = "这是查询一个用户的测试接口", value = "Query By ID")
    @GetMapping(value = "/user/find", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public User queryById(@ApiParam(value = "id", required = true, example = "1") Integer id) {
        return null;
    }

    @ApiOperation(value = "query user names", notes = "获取用户姓名列表")
    @GetMapping("/user-names/query")
    @ResponseBody
    public List<String> findAll(@RequestParam User user) {
        return null;
    }

    @ApiOperation(value = "query user names by ids", notes = "根据id获取用户姓名列表")
    @GetMapping("/user-names-by-id/query")
    @ResponseBody
    public List<String> findAllById(@RequestParam List<Long> ids) {
        return null;
    }

    @ApiOperation(value = "query user name and age", notes = "获取用户姓名和年龄")
    @GetMapping("/user-name-age/query")
    @ResponseBody
    public Map<String, Integer> queryUsernameandage(@RequestBody User user) {
        return null;
    }

    @ApiOperation(value = "do nothing", notes = "返回空值测试")
    @PostMapping("/nothing/{user}/do")
    public void doNothing(@PathVariable User user) {
        //do nothing;
    }

    @ApiOperation(value = "Get now time cookie", notes = "获取当前时间 cookie")
    @GetMapping("/now-time/read")
    public Date getCurrentTime(@CookieValue User user) {
        return new Date();
    }

    @ApiOperation(value = "Get now time by id cookie", notes = "获取当前时间byid")
    @GetMapping("/now-time-by-id/read")
    public Date getCurrentTimeById(@CookieValue Integer id) {
        return new Date();
    }

    @ApiOperation(value = "Get now time Default", notes = "获取当前时间 Default")
    @GetMapping("/now-time-default/read")
    public Date getCurrentTimeDefault(User user) {
        return new Date();
    }

    @ApiOperation(value = "Get now time by id Default", notes = "获取当前时间Default")
    @GetMapping("/now-time-by-default/read")
    public Date getCurrentTimeByIdDefault(Integer id) {
        return new Date();
    }

    @ApiOperation(value = "Get author name", notes = "获取作者姓名")
    @GetMapping("/author-name/get")
    public String getAuthorName(@RequestHeader User user) {
        return "nikai";
    }

    @ApiOperation(value = "Get author id", notes = "获取作者id")
    @GetMapping("/author-id/get")
    public Long getAuthorId(@RequestPart User user) {
        return 1L;
    }

    @ApiOperation(value = "Get author age", notes = "获取作者年龄")
    @GetMapping("/author-age/get")
    public Integer getAuthorAge(@RequestPart Integer id) {
        return 23;
    }

    @ApiOperation(value = "list list list", notes = "multi list test")
    @GetMapping("/list/list")
    public List<List<List<String>>> lists(@RequestHeader Long id) {
        return null;
    }


    @ApiOperation(value = "get object tet",notes = "object 类型测试")
    @GetMapping("/object/get")
    public Object getObjecttest(@RequestParam Object ino)
    {
        return null;
    }

    @ApiOperation(value = "post object tet",notes = "object 类型测试")
    @PostMapping("/object/post")
    public Object postObjecttest(@RequestBody Object ino)
    {
        return null;
    }


    @ApiOperation(value = "get user array",notes = "获取用户数组")
    @GetMapping("/user-array/get")
    public User[] getUserArray(String[] ids){
        return null;
    }

    @ApiOperation(value = "get user byte",notes = "获取用户字节")
    @GetMapping("/user-bytes/get")
    public Byte[] getBytes(BigDecimal price){
        return null;
    }
}
