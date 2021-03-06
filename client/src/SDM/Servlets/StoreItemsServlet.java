package SDM.Servlets;

import Dtos.ItemInStoreDto;
import Engine.SDMInterface;
import SDM.Utils.ServletUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StoreItemsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SDMInterface sdmInterface = ServletUtils.getSDMManager(getServletContext());
        Gson gson = new Gson();
        int storeId = Integer.parseInt(req.getParameter("storeId"));
        String zoneName = req.getParameter("zone");
        Map<Integer, ItemInStoreDto> items = sdmInterface.getAllZones().get(zoneName).getMarketStores().get(storeId).getItems();
        String json = gson.toJson(items);
        resp.getWriter().write(json);
    }
}
