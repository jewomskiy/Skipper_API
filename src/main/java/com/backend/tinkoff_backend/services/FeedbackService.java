package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Feedback;
import com.backend.tinkoff_backend.repositories.FeedbackRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public void createFeedback(Feedback feedback) {
        feedbackRepository.save(new Feedback(feedback.getRating(), feedback.getComment(),
                feedback.getDemandEmployeeId(), feedback.getReviewerName()));
    }

    public Feedback getFeedbackById(long feedbackId) throws ServiceException {
        Optional<Feedback> feedbackData = feedbackRepository.findById(feedbackId);

        if (feedbackData.isPresent())
            return feedbackData.get();
        throw new ServiceException("No such feedback");
    }

    public List<Feedback> getFeedbacksByDemandEmployeeId(long demandEmployeeId) throws ServiceException {
        List<Feedback> feedbacks = feedbackRepository.findAllByDemandEmployeeId(demandEmployeeId);

        if (feedbacks.isEmpty())
            throw new ServiceException("This demandEmployee hasn't receive any feedbacks yet");
        return feedbacks;
    }

    public List<Feedback> getAllFeedbacks() throws ServiceException {
        List<Feedback> feedbacks = feedbackRepository.findAll();

        if (feedbacks.isEmpty())
            throw new ServiceException("No feedbacks");
        return feedbacks;
    }

    public Feedback updateFeedback(long feedbackId, Feedback feedback) throws ServiceException {
        Optional<Feedback> feedbackData = feedbackRepository.findById(feedbackId);

        if (feedbackData.isPresent()) {
            Feedback _feedback = feedbackData.get();
            _feedback.setComment(feedback.getComment());
            _feedback.setRating(feedback.getRating());
            _feedback.setReviewerName(feedback.getReviewerName());
            _feedback.setDemandEmployeeId(feedback.getDemandEmployeeId());
            return feedbackRepository.save(_feedback);
        }
        throw new ServiceException("No such feedback");
    }

    public void deleteFeedback(long feedbackId) throws ServiceException {
        Optional<Feedback> feedbackData = feedbackRepository.findById(feedbackId);

        if (feedbackData.isPresent()){
            feedbackRepository.deleteById(feedbackId);
            return;
        }
        throw new ServiceException("No such feedback");
    }

    public void deleteAllFeedbacks() {
        feedbackRepository.deleteAll();
    }
}