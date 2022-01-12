package com.example.demo.Controllers;

import com.example.demo.Models.Upload;
import com.example.demo.Repositories.UploadRepo;
import org.eclipse.microprofile.faulttolerance.Bulkhead;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;

@Path("/upload")
public class UploadController {
    @Inject
    private UploadRepo uploadRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Bulkhead(5)
    public List<Upload> viewUploads() {

        return uploadRepo.getUploads(null);
    }

    @GET
    @Path("/{author}")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed(name = "Time",
            tags = {"method=get"},
            absolute = true,
            description = "Time required")
    @Counted(name = "Count",
            absolute = true,
            description = "Calls")
    @Retry(maxRetries = 1, delay = 200, jitter = 50)
    @Fallback(fallbackMethod = "fallback")
    public List<Upload> viewDocumentByAuthor(@PathParam("author") String author) {
        return uploadRepo.getUploads(author);
    }

    private List<Upload> onFallback(String author) {
        return Collections.emptyList();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteDocument(@PathParam("id") Long id) {
        uploadRepo.delete(id);

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @CircuitBreaker(successThreshold = 10, requestVolumeThreshold = 4, failureRatio = 0.90, delay = 1000)
    public Upload update(Upload documents) {
        return uploadRepo.update(documents);
    }
}
