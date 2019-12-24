package hys.mongodb.controller;
/**
 * @Author: csj
 * @Description:
 * @Date: 2019/9/2 9:21
 */

import hys.mongodb.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rmjk.bean.mgdb.Question;
import rmjk.common.JsonData;

import java.util.List;

/**
 * @ClassName
 * @Description 存取题目
 * @Author csj
 * @Date 2019/9/2 9:21
 **/
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    /**
     * @param data 保存的数据
     */
    @PostMapping("/saveOrUpdateQuestion")
    public JsonData saveOrUpdateQuestion(@RequestBody Question data) {
        questionService.saveOrUpdateQuestion(data);
        return JsonData.success(data.getId());
    }

    /**
     * @param id 删除的id
     */
    @PostMapping("/delQuestion")
    public JsonData delQuestion(@RequestParam String id) {
        questionService.delQuestion(id);
        return JsonData.success();
    }

    /**
     * @param id 查找的id
     */
    @GetMapping("/question")
    public Question question(String id) {
        return questionService.question(id);
    }

    /**
     * @param dataId    文章id
     * @param pageNo 当前页
     * @param pageNo 每页数量
     */
    @GetMapping("/listQuestion")
    public List<Question> listQuestion(@RequestParam(required = false) String dataId, @RequestParam(required = false) Integer pageNo, @RequestParam(required = false) Integer pageSize) {
        return questionService.listQuestion(dataId, pageNo, pageSize);
    }
}
