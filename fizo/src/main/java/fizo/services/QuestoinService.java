package fizo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fizo.entities.Question;
import fizo.repos.QuestoinRepo;

@Service
@Transactional
public class QuestoinService {
		private final QuestoinRepo questionRepo;

		public QuestoinService(QuestoinRepo questionRepo) {
			this.questionRepo = questionRepo;
		}
		public void addQuestion(Question question){
			questionRepo.save(question);
		}
		public void removeQuestion(int id){
			questionRepo.delete(id);
		}
		public void removeQuestion(Question question){
			questionRepo.delete(question);
		}
		public void addAnswer(String answer,int id){
			Question tmp = questionRepo.findOne(id);
			List<String> ans=tmp.getAnswers();
			ans.add(answer);
			questionRepo.save(tmp);
		}
		public void setAnswer(List<String> ans,int id){
			Question tmp = questionRepo.findOne(id);
			tmp.setAnswers(ans);
			questionRepo.save(tmp);
		}
		public List<String> getAnswer(int id){
			Question tmp = questionRepo.findOne(id);
			return tmp.getAnswers();
		}
		public void setCorrectAns(String ans,int id){
			Question tmp = questionRepo.findOne(id);
			tmp.setCorrectAnswer(ans);
			questionRepo.save(tmp);
		}
		public String getCorrectAns(int id){
			Question tmp = questionRepo.findOne(id);
			return tmp.getCorrectAnswer();
		}
		public void setGameType(String type,int id){
			Question tmp = questionRepo.findOne(id);
			tmp.setGameType(type);
			questionRepo.save(tmp);
		}
		public String getGameType(int id){
			Question tmp = questionRepo.findOne(id);
			return tmp.getGameType();
		}
		public Question getQuestion(int id){
			Question tmp = questionRepo.findOne(id);
			return tmp;
		}
		public String getQuestionString(int id){
			Question tmp = questionRepo.findOne(id);
			return tmp.getQuestion();
		}
		public void setQuestionString(String questoin, int id){
			Question tmp = questionRepo.findOne(id);
			tmp.setQuestion(questoin);
			questionRepo.save(tmp);
		}
		public Question fetchQuestion(int id){
			return questionRepo.findOne(id);
		}
}
