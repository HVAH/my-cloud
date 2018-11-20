package com.mall.order.controller;

import com.mall.order.common.AjaxReturn;
import com.mall.order.domain.SkusCache;
import com.mall.order.service.ProductService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 商品controller
 * @Author HuangJiang
 * @Date 2018/8/9 14:28
 * @Version 1.0
 **/
@RestController
@Api(description = "product相关接口")
public class ProductController {
    private @Resource ProductService productService;

    /**
     * 根据sceneId获取sku清单
     * @param sceneId
     * @return
     * @throws Exception
     */
    @GetMapping(path = { "/get-skus" })
    @ApiOperation(value = "根据sceneId获取sku清单", code = 200, produces = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "查询成功", response = SkusCache.class) })
    public AjaxReturn getSkus(
            @ApiParam(name = "sceneId", value = "sceneId, 如是ios截取地址最后的那一串", required = true) @RequestParam(name = "sceneId", required = true) String sceneId
    )throws Exception {

        SkusCache result = productService.getOrderConfirmOrderInfo(sceneId);
        return new AjaxReturn(200, null, result);
    }

    /**
     * 生成微信推广二维码
     * @param
     * @return
     * @throws Exception
     */
    @GetMapping(path = { "/get-qr-url" })
    @ApiOperation(value = "返回二维码地址", code = 200, produces = "application/json")
    @ApiResponses({ @ApiResponse(code = 200, message = "创建成功", response = String.class) })
    public AjaxReturn getUrl(
            @ApiParam(name = "skuIds", value = "例: 476432536401690624,476432536523325440", required = true) @RequestParam(name = "skuIds", required = true) List<Long> skuIds,
            @ApiParam(name = "picId", value = "该场景的截图id", required = true) @RequestParam(name = "picId", required = true) String picId
    )throws Exception {

        String url = productService.createTempOrder(skuIds, picId);
        return new AjaxReturn(200, null, url);
    }


}
