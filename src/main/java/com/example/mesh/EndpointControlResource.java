package com.example.mesh;

import java.util.Collections;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EndpointControlResource {

    /**
     * @see <a href="https://relay.bluejeans.com/docs/mesh.html#callactive">https://relay.bluejeans.com/docs/mesh.html#callactive</a>
     */
    @GET
    @Path("{ipAddress}/callactive")
    public Map<String, Boolean> callActive(@PathParam("ipAddress") final String ipAddress, @QueryParam("port") final Integer port,
            @QueryParam("name") final String name) {
        System.out.println("Received callactive request");
        System.out.println("  ipAddress = " + ipAddress);
        System.out.println("  port = " + port);
        System.out.println("  name = " + name);

        return Collections.singletonMap("callActive", false);
    }

    /**
     * @see <a href="https://relay.bluejeans.com/docs/mesh.html#join">https://relay.bluejeans.com/docs/mesh.html#join</a>
     */
    @POST
    @Path("{ipAddress}/join")
    public void join(@PathParam("ipAddress") final String ipAddress, @QueryParam("dialString") final String dialString,
            @QueryParam("meetingId") final String meetingId, @QueryParam("passcode") final String passcode,
            @QueryParam("bridgeAddress") final String bridgeAddress, final Endpoint endpoint) {
        System.out.println("Received join request");
        System.out.println("  ipAddress = " + ipAddress);
        System.out.println("  dialString = " + dialString);
        System.out.println("  meetingId = " + meetingId);
        System.out.println("  passcode = " + passcode);
        System.out.println("  bridgeAddress = " + bridgeAddress);
        System.out.println("  endpoint = " + endpoint);
    }

    /**
     * @see <a href="https://relay.bluejeans.com/docs/mesh.html#hangup">https://relay.bluejeans.com/docs/mesh.html#hangup</a>
     */
    @POST
    @Path("{ipAddress}/hangup")
    public void hangup(@PathParam("ipAddress") final String ipAddress, final Endpoint endpoint) {
        System.out.println("Received hangup request");
        System.out.println("  ipAddress = " + ipAddress);
        System.out.println("  endpoint = " + endpoint);
    }

}
