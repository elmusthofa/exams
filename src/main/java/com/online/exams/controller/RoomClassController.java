package com.online.exams.controller;

import com.online.exams.entity.RoomClass;
import com.online.exams.request.RoomClassRequest;
import com.online.exams.service.RoomClassService;
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
@RequestMapping(value = "room-class", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Room Class API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Room Class"})
@RequiredArgsConstructor
public class RoomClassController {

    private final RoomClassService roomClassService;

    @GetMapping("find-all")
    @ApiOperation(value = "List data kelas dengan pagination", response = JsonResponse.class)
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        Page<RoomClass> roomClassPage = roomClassService.findAllPage(page, size);
//        List<RoomClass> roomList = roomClassService.findAll();
        return ResponseEntity.ok(JsonResponse.ok(roomClassPage));
    }

    @PostMapping("add")
    @ApiOperation(value = "Tambah data kelas")
    public ResponseEntity<?> add(@Valid @RequestBody RoomClassRequest request) {
        roomClassService.add(request);
        return ResponseEntity.ok(JsonResponse.ok("Data berhasil disimpan !"));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> removeOne(@PathVariable("id") String id) {
        roomClassService.delete(id);

        return ResponseEntity.ok(JsonResponse.ok(null, "Data berhasil dihapus"));
    }
    //
    @PostMapping("update/{id}")
    @ApiOperation(value = "Data Update Kelas", response = JsonResponse.class)
    public ResponseEntity<?> update(@RequestBody RoomClassRequest request,@PathVariable("id") String id) {
        roomClassService.update(request, id);
        return ResponseEntity.ok(JsonResponse.ok(null, "Data berhasil diupdate"));
    }
}
