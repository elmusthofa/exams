package com.online.exams.controller;

import com.online.exams.entity.User;
import com.online.exams.exception.Constant;
import com.online.exams.request.UserRequest;
import com.online.exams.service.UserService;
import com.online.exams.util.JsonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "User API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"User"})
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("find-all")
    @ApiOperation(value = "List data user dengan pagination", response = JsonResponse.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.HEADER_PAGE, defaultValue = "0", paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = Constant.HEADER_SIZE, defaultValue = "10", paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "sort", paramType = "query", defaultValue = "createdDate,desc", dataType = "string"),
    })
    public ResponseEntity<?> findAll(@ApiParam(hidden = true) @ApiIgnore
                                    @PageableDefault(direction = Sort.Direction.DESC, sort = "createdDate") Pageable pageable) {
        Page<User> userList = userService.findAllPage(pageable);
//        List<User> userList = userService.findAll();
        return ResponseEntity.ok(JsonResponse.ok(userList));
    }

    @PostMapping("add")
    @ApiOperation(value = "Tambah data user")
    public ResponseEntity<?> add(@Valid @RequestBody UserRequest request) {
        userService.add(request);
        return ResponseEntity.ok(JsonResponse.ok("Data berhasil disimpan !"));
    }

//    @PostMapping
//    @ApiOperation(value = "Data Save User", response = JsonResponse.class)
//    public ResponseEntity<?> save(@RequestBody UserReq userReq) {
//        userService.save(userReq);
//        return ResponseEntity.ok(JsonResponse.ok(null, "Data berhasil disimpan"));
//    }
//
//    @GetMapping("find-all")
//    @ApiOperation(value = "Data User", response = JsonResponse.class)
//    public ResponseEntity<?> findAll() {
//        return ResponseEntity.ok(JsonResponse.ok(userService.findAll()));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> removeOne(@PathVariable("id") String id) {
//        userService.delete(id);
//
//        return ResponseEntity.ok(JsonResponse.ok(null, "Data berhasil dihapus"));
//    }
//
//    @PostMapping("/{id}")
//    @ApiOperation(value = "Data Update User", response = JsonResponse.class)
//    public ResponseEntity<?> update(@RequestBody UserReq userReq,@PathVariable("id") String id) {
//        userService.update(userReq, id);
//        return ResponseEntity.ok(JsonResponse.ok(null, "Data berhasil diupdate"));
//    }
}
