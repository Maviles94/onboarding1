package MyApp.com.MindHub.MyApp.Controller;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @GetMapping("/api/greeting")
    @Operation(summary = "Get Greeting", description = "Returns a greeting message.")
    public String getGreeting() {
        return "Hello, World!";
    }

    @PostMapping("/api/submit") //
    @Operation(summary = "Submit Data", description = "Receives data and returns a confirmation message.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The data to be submitted",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(type = "string", example = "Sample data"))))
    public String submitData(@RequestBody String data) {
        System.out.println(data);
        return "Data received: " + data;
    }

    @GetMapping("/api/user/{id}")
    public String getUserById(@PathVariable("id") Long id) {
        return "User ID: " + id;
    }

    @GetMapping("/api/search")
    @Operation(summary = "Search", description = "Searches for items based on a query parameter.")
    public String search(
            @RequestParam(name = "query", defaultValue = "")
            @Parameter(description = "Search query")String query) {
        return "Search results for: " + query;
    }
    public class MyRequest {
        @Schema(description = "The data to be submitted", example = "Hello")
        private String data;
    }
}
