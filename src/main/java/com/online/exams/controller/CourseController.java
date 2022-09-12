package com.online.exams.controller;

import com.online.exams.entity.Course;
import com.online.exams.request.CourseRequest;
import com.online.exams.service.CourseService;
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
@RequestMapping(value = "course", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Course API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Course"})
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("find-all")
    @ApiOperation(value = "List data course dengan pagination", response = JsonResponse.class)
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        Page<Course> coursePage = courseService.findAllPage(page, size);
//        List<RoomClass> roomList = roomClassService.findAll();
        return ResponseEntity.ok(JsonResponse.ok(coursePage));
    }

    @PostMapping("add")
    @ApiOperation(value = "Tambah data course")
    public ResponseEntity<?> add(@Valid @RequestBody CourseRequest request) {
        courseService.add(request);
        return ResponseEntity.ok(JsonResponse.ok("Data berhasil disimpan !"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> removeOne(@PathVariable("id") String id) {
        courseService.delete(id);

        return ResponseEntity.ok(JsonResponse.ok(null, "Data berhasil dihapus"));
    }
    //
    @PostMapping("update/{id}")
    @ApiOperation(value = "Data Update Kelas", response = JsonResponse.class)
    public ResponseEntity<?> update(@RequestBody CourseRequest request,@PathVariable("id") String id) {
        courseService.update(request, id);
        return ResponseEntity.ok(JsonResponse.ok(null, "Data berhasil diupdate"));
    }
}
