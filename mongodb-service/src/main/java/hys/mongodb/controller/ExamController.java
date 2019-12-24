package hys.mongodb.controller;/**
 * @Author: csj
 * @Description:
 * @Date: 2019/9/2 10:08
 */

import hys.mongodb.services.ExamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rmjk.bean.mgdb.Exam;
import rmjk.common.JsonData;

/**
 * @ClassName
 * @Description 试卷
 * @Author csj
 * @Date 2019/9/2 10:08
 **/
@RestController
@RequestMapping("/exam")
@Api(value = "试卷相关模块", description = "试卷相关模块")
public class ExamController {

    @Autowired
    private ExamService examService;

    /**
     * @param no 数量
     */
    @PostMapping("/creatExam")
    @ApiOperation(value = "为用户生成一张试卷", notes = "直接答题no传10，学习no传30，生成试卷并不会保存这张试卷，只有答题才会保存", hidden = true)
    public Exam creatExam(@RequestBody Exam data, int no) {
        if (no > 100) no = 100; //上限为100
        return examService.creatExam(data.getUid(), no);
    }

    /**
     * @param data 答题
     * @return
     */
    @PostMapping("/saveExam")
    @ApiOperation(value = "保存试卷", hidden = true)
    public JsonData saveExam(@RequestBody Exam data) {
        return examService.saveExam(data);
    }

    /**
     * @param id 查找的id
     */
    @ApiOperation(value = "根据id查询试卷", notes = "试卷id查询试卷")
    @GetMapping("/exam")
    public Exam exam(String id) {
        return examService.exam(id);
    }
}
