package com.online.exams.controller;

import com.online.exams.entity.User;
import com.online.exams.request.UserRequest;
import com.online.exams.service.UserService;
import com.online.exams.util.JsonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "user", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "User API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"User"})
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("find-all")
    @ApiOperation(value = "List data user dengan pagination", response = JsonResponse.class)
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        Page<User> userList = userService.findAllPage(page, size);
//        List<User> userList = userService.findAll();
        return ResponseEntity.ok(JsonResponse.ok(userList));
    }

    @PostMapping("add")
    @ApiOperation(value = "Tambah data user")
    public ResponseEntity<?> add(@Valid @RequestBody UserRequest request) {
        userService.add(request);
        return ResponseEntity.ok(JsonResponse.ok("Data berhasil disimpan !"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> removeOne(@PathVariable("id") String id) {
        userService.delete(id);

        return ResponseEntity.ok(JsonResponse.ok(null, "Data berhasil dihapus"));
    }
//
    @PostMapping("update/{id}")
    @ApiOperation(value = "Data Update User", response = JsonResponse.class)
    public ResponseEntity<?> update(@RequestBody UserRequest request,@PathVariable("id") String id) {
        userService.update(request, id);
        return ResponseEntity.ok(JsonResponse.ok(null, "Data berhasil diupdate"));
    }
}
