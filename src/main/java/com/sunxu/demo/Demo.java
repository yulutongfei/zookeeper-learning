class AckRequestProcessor implements RequestProcessor {

    public void processRequest(Request request) {
        QuorumPeer self = leader.self;
        if (self != null)
            leader.processAck(self.getId(), request.zxid, null);
        else
            LOG.error("Null QuorumPeer");
    }
}