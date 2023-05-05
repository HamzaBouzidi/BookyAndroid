import  express  from "express";
import { getAllConversations,getAllMessages,getMyConversations,getMyMessages
    ,createConversation,sendMessage,deleteConversation,deleteMessage,deleteAll } from "../controllers/chat.controller.js"


const router = express.Router();


router.get("/", getAllConversations)
router.get("/tout-messages", getAllMessages)
router.get("/my-conversations/:senderId", getMyConversations)
router.get("/my-messages/:conversationId", getMyMessages)
router.post("/create-conversation", createConversation)
router.post("/send-message", sendMessage)
router.delete("/", deleteConversation)
router.delete("/message", deleteMessage)
router.delete("/deleteAll", deleteAll)

export default router;